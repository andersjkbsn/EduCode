package com.educode;

import com.educode.types.Type;

/**
 * Created by User on 15-Apr-17.
 */
public interface Typeable
{
    Type getType();
    void setType(Type type);
    boolean isType(Type type);
}