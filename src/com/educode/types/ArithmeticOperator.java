package com.educode.types;

/**
 * Created by zen on 3/24/17.
 */
public class ArithmeticOperator
{
    private byte _kind;
    private static byte ERROR = 0, ADDITION = 1, SUBTRACTION = 2, MULTIPLICATION = 3, DIVISION = 4, MODULO = 5;

    public ArithmeticOperator(byte kind)
    {
        this._kind = kind;
    }

    @Override
    public boolean equals(Object o)
    {
        if (o instanceof ArithmeticOperator)
            return ((ArithmeticOperator)o)._kind == this._kind;
        return false;
    }

    public static final ArithmeticOperator Addition = new ArithmeticOperator(ADDITION);
    public static final ArithmeticOperator Subtraction = new ArithmeticOperator(SUBTRACTION);
    public static final ArithmeticOperator Multiplication = new ArithmeticOperator(MULTIPLICATION);
    public static final ArithmeticOperator Division = new ArithmeticOperator(DIVISION);
    public static final ArithmeticOperator Modulo = new ArithmeticOperator(MODULO);
    
    public static final ArithmeticOperator Error = new ArithmeticOperator(ERROR);
}
