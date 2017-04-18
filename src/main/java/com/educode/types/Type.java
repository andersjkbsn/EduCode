package com.educode.types;

import com.educode.Typeable;
import com.educode.symboltable.SymbolTable;

/**
 * Created by zen on 3/10/17.
 */
public class Type
{
    private Type _childType = null;
    private final byte _kind;

    public static final byte VOID = 0, BOOL = 1, NUMBER = 2, COORDINATES = 3, STRING = 4, ERROR = 5, ENTITY = 6, COLLECTION = 7, ROBOT = 8;

    private static SymbolTable _baseSymbolTable, _collectionSymbolTable, _entitySymbolTable, _robotSymbolTable, _coordinatesSymbolTable;

    static
    {
        // Initialize default types
        VoidType = new Type(VOID);
        BoolType = new Type(BOOL);
        NumberType = new Type(NUMBER);
        CoordinatesType = new Type(COORDINATES);
        StringType = new Type(STRING);
        EntityType = new Type(ENTITY);
        RobotType = new Type(ROBOT);
        Error = new Type(ERROR);

        // Add base symbol table
        _baseSymbolTable = new SymbolTable(null);
        _baseSymbolTable.addDefaultMethod("toString", Type.StringType);

        // Add default fields for coordinates
        _coordinatesSymbolTable = new SymbolTable(_baseSymbolTable);
        _coordinatesSymbolTable.addDefaultField("x", Type.NumberType);
        _coordinatesSymbolTable.addDefaultField("y", Type.NumberType);
        _coordinatesSymbolTable.addDefaultField("z", Type.NumberType);

        // Add default methods for collections
        _collectionSymbolTable = new SymbolTable(_baseSymbolTable);

        // Add default methods for entities
        _entitySymbolTable = new SymbolTable(_baseSymbolTable);
        _entitySymbolTable.addDefaultMethod("getHealth", Type.NumberType);
        _entitySymbolTable.addDefaultMethod("getX", Type.NumberType);
        _entitySymbolTable.addDefaultMethod("getY", Type.NumberType);
        _entitySymbolTable.addDefaultMethod("getZ", Type.NumberType);

        // Add default methods for robot
        _robotSymbolTable = new SymbolTable(_entitySymbolTable);
        _robotSymbolTable.addDefaultMethod("move", Type.VoidType, Type.StringType);
    }

    public Type(byte kind)
    {
        this._kind = kind;
    }

    public Type(Type child)
    {
        this(COLLECTION);
        this._childType = child;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof Type)
        {
            Type otherType = (Type) o;

            if (otherType._kind == this._kind)
            {
                if (this.getChildType() != null && otherType.getChildType() != null)
                    return this.getChildType().equals(otherType.getChildType());
                else
                    return true;
            }
        }

        return false;
    }

    public byte getKind()
    {
        return this._kind;
    }

    public Type getChildType()
    {
        return this._childType;
    }

    public boolean isReferenceType()
    {
        return this._kind == COLLECTION || this._kind == ENTITY || this._kind == ROBOT || this._kind == COORDINATES;
    }

    public SymbolTable getSymbolTable()
    {
        if (this.equals(Type.EntityType))
            return _entitySymbolTable;
        else if (this.equals(Type.RobotType))
            return _robotSymbolTable;
        else if (this.equals(Type.CoordinatesType))
            return _coordinatesSymbolTable;
        else if (this.isCollection())
            return _collectionSymbolTable;

        return _baseSymbolTable;
    }

    public boolean isCollection()
    {
        return this._kind == COLLECTION;
    }

    @Override
    public String toString()
    {
        switch (_kind)
        {
            case Type.NUMBER:
                return "NUMBER";
            case Type.STRING:
                return "STRING";
            case Type.BOOL:
                return "BOOLEAN";
            case Type.COORDINATES:
                return "COORDINATES";
            case Type.VOID:
                return "VOID";
            case Type.ERROR:
                return "ERROR";
            case Type.ENTITY:
                return "ENTITY";
            case Type.COLLECTION:
                return "COLLECTION<" + this.getChildType() + ">";
            case Type.ROBOT:
                return "ROBOT";
            default:
                return "UNDEFINED"; // Should not happen
        }
    }

    public static final Type VoidType;
    public static final Type BoolType ;
    public static final Type NumberType;
    public static final Type CoordinatesType;
    public static final Type StringType;
    public static final Type EntityType;
    public static final Type RobotType;
    public static final Type Error;
}