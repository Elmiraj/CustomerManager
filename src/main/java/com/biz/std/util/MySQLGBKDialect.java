package com.biz.std.util;

import org.hibernate.NullPrecedence;
import org.hibernate.dialect.MySQL5Dialect;

/**
 * MySQLGBKDialect class
 * @author junzhang
 * @date 2018-12-20
 */
public class MySQLGBKDialect extends MySQL5Dialect {
    public MySQLGBKDialect()
    {
    }

    @Override
    public String renderOrderByElement(String expression, String collation, String order, NullPrecedence nulls)
    {
        expression = "convert(" + expression + " using 'gbk')";
        return super.renderOrderByElement(expression, collation, order, nulls);
    }
}
