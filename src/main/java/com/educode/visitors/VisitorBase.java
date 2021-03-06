package com.educode.visitors;

import com.educode.nodes.base.BinaryNode;
import com.educode.nodes.base.NaryNode;
import com.educode.nodes.base.Node;
import com.educode.nodes.base.UnaryNode;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * Created by User on 15-Apr-17.
 */
public abstract class VisitorBase
{
    public abstract Object defaultVisit(Node node);

    public Object visit(Object node)
    {
        if (node == null)
        {
            System.out.println("Attempted to visit a null object!");
            new Exception().printStackTrace(); // Print stack trace for debugging purposes
            return null;
        }

        // Get best method for this object
        Method method = getMethodFor(node);

        // Attempt to invoke the method
        try
        {
            return method.invoke(this, node);
        }
        catch (IllegalAccessException | InvocationTargetException e)
        {
            e.printStackTrace();
        }

        return null;
    }

    private Method getMethodFor(Object node)
    {
        Method ans = null;

        // Find a method which matches the class of the node
        Class currentClass = node.getClass();
        while (ans == null && currentClass != Object.class && currentClass != Node.class)
        {
            try
            {
                ans = this.getClass().getMethod("visit", currentClass);
            }
            catch (NoSuchMethodException e)
            {
                // This may happen if the implementation of the visitor does implement a visitor for all nodes
            }

            // If no appropriate method was found, look in its superclass
            if (ans == null)
                currentClass = currentClass.getSuperclass();
        }

        // If no method was found, return default method
        if (ans == null)
        {
            try
            {
                ans = this.getClass().getMethod("defaultVisit", Node.class);
            }
            catch (NoSuchMethodException e)
            {
                // Should not happen since defaultVisit is abstract and must be implemented
            }
        }

        return ans;
    }

    protected void visitChildren(Node node)
    {
        if (node instanceof UnaryNode)
            visitChildren((UnaryNode) node);
        else if (node instanceof BinaryNode)
            visitChildren((BinaryNode) node);
        else if (node instanceof NaryNode)
            visitChildren((NaryNode) node);
    }

    protected void visitChildren(UnaryNode node)
    {
        if (node.getChild() != null)
            visit(node.getChild());
    }

    protected void visitChildren(BinaryNode node)
    {
        if (node.getLeftChild() != null)
            visit(node.getLeftChild());
        if (node.getRightChild() != null)
            visit(node.getRightChild());//
    }

    protected void visitChildren(NaryNode node)
    {
        List<Node> children = node.getChildren();

        for (int i = 0; i < children.size();)
        {
            visit(children.get(i));

            // Delete children that have been marked for deletion (set to null)
            if (children.get(i) == null)
                children.remove(i);
            else
                i++;
        }
    }
}
