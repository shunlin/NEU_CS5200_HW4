package dao;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * Created by shunlin on 3/26/15.
 */
public abstract class Manager {
    DataSource ds;

    public Manager() {
        try {
            Context ctx = new InitialContext();
            ds = (DataSource)ctx.lookup("java:comp/env/jdbc/DB_HW4");
        } catch (NamingException e) {
            e.printStackTrace();
        }
    }
}
