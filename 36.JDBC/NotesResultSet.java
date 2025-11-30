Statement statement = Connection.createStatement();

Statement connection.createStatement(
  ResultSet.TYPE_FORWARD_ONLY,
  ResultSet.CONCUR_READ_ONLY,
);

Statement statement = connection.createStatement(
  ResultSet, TYPE_FORWARD_ONLY,
  ResultSet, CONCUR_READ_ONLY,
  ResultSet, CLOSE_CURSORS_OVER_COMMIT
);

PreparedStatement statement = connection.prepareStatement (sql,
  ResultSet.TYPE_FORWARD_ONLY,
  ResultSet.CONCUR_READ_ONLY,
  ResultSet.CLOSE_CURSORS_OVER_COMMIT
);

/***********************************TYPE TYPE TYPE TYPE TYPE*******************************************/

/* A ResultSet can be of a certain type. The type determines some characteristics and abilities of the ResultSet */
/* Not all types are supported by all databases and JDBC drivers. You will have to check your database and JDBC driver to see 
if it supports the type you want to use. The DatabaseMetaData.supportsResultSetType(int type) method returns true or false 
depending on whether the given type is supported or not. */
DatabaseMetaData dbmd = c.getMetaData();
boolean b = dbmd.supportsResultSetType(ResultSet.TYPE_SCROLL_SENSITIVE);
// there are 3 ResultSet types:-
    ResultSet.TYPE_FORWARD_ONLY
    ResultSet.TYPE_SCROLL_SENSITIVE
    ResultSet.TYPE_SCROLL_INSENSITIVE

/* The default is TYPE_FORWARD_ONLY
TYPE_FORWARD_ONLY means that the ResultSet can only be navigated forward. That is, you can only move from row 1, to row 2, 
to row 3, etc.  You cannot move backwards in the ResultSet.

TYPE_SCROLL_INSENSITIVE means that the ResultSet can be navigated (scrolled) both forward and backwards. You can also jump to a 
position relative to the current position, or jump to an absolute position. The ResultSet is insensitive to changes in the underlying 
data source while the ResultSet is open. That is, if a record in the ResultSet is changed in the database by another thread or 
process, it will not be reflected in already opened ResultSet's of this type. 

TYPE_SCROLL_SENSITIVE menas that the ResultSet can be navigated (scrolled) both forward and backwards. You can also jump to a 
position relative to the current position, or jump to an absolute position. The ResultSet is sensitive to changes in the underlying 
data source while the ResultSet is open. That is, if a record in the ResultSet is changed in the database by another thread or 
process, it will be reflected in already opened ResultSet's of this type. */

/* Navigation Methods
The ResultSet interface contains the following navigation methods. Remember, not all methods work with all ResultSet types. What methods
works depend on your database, JDBC Driver, and the ResultSet type. These are:  */
absolute(int row) //Moves the ResultSet to point at an absolute position. The position is a row number passed as parameter to the
          // absolute() method.
afterLast()   // Moves the ResultSet to point after the last row in the ResultSet
beforeFirst() // Moves the ResultSet to point before the first row in ResultSet
first()   // Moves the ResultSet to point at the first row in the ResultSet.
last()  // Moves the ResultSet to point at the last row in the ResultSet.
next()  // Moves the ResultSet at the next row in the ResultSet.
previous()  // Moves the ResultSet to point at the previous row in the ResultSet.
relative(int row) //Moves the ResultSet to point to a position relative to its current position. The relative position is passed as a
        // parameter to the relative method, and can be both positive and negative.

/* Method Description
The ResultSet interface also contains a set of methods you can use to inquire about the current position of the ResultSet.These are: */
getRow()  // Returns the row number of the current row - the row currently pointed to by the ResultSet.
int getType() // Returns the ResultSet type.
isAfterLast() // Returns true if the ResultSet points after the last row. False if not.
isBeforeFirst() // Returns true if the ResultSet points before the first row. False if not.
isFirst()  // Returns true if the ResultSet points at the first row. False if not.

//Finally, ResultSet interface also contains a method to update a row with database changes, if the ResultSet is sensitive to change.
refreshRow() //Refreshes the column values of that row with the latest values from the database.


/********************************************Concurrency Concurrency Concurrency**********************************************/

int getConcurrency() 
// the resultSet concurrency determines whether the ResultSet can be updated, or only read.

/* Some databases and JDBC drivers support that the ResultSet is updated, but not all databases and JDBC drivers do. 
The DatabaseMetaData.supportsResultSetConcurrency(int concurrency) method return true or false depending on whether the given concurrency
mode is supportedor not. */

//  A ResultSet can have one of two concurrency levels:
     ResultSet.CONCUR_READ_ONLY   // ResultSet can only be read
     ResultSet.CONCUR_UPDATABLE   // ResultSet can be both read and updated.

/* If a ResultSet id updatable, you can update the columns of each row in the ResultSet. You do so using the many updateXXX() methods.
For instance: */
     result.updateString    ("name", "lalu");
     result.updateInt       ("age", 55);
     result.updateBigDecimal("coefficient", new BigDecimal("0.1323"))
     result.updateRow();

/* You can also update a cloumn using column index instead of column name. Here is an example:  */
     result.updateString    (1, "Alex");
     result.updateInt       (2, 55);
     result.updateBigDecimal(3, new BigDecimal("0.1323"));
     result.updateRow();

/* Notice the updateRow() call. It is when updateRow() is called that the database is updated with the values of the row. If you do
   not call this method, the values updated in the ResultSet are never sent to the database. */

/* If you call updateRow() inside a transaction, the data is not actually committed to the database until the transaction is 
    commited. */

// Here is an example:
     result.moveToInsertRow();
     result.updateString     (1, "Alex");
     result.updateInt        (2, 55);
     result.updateBigDecimal (3, new BigDecimal("0.1323"));
     result.insertRow();

     result.beforeFirst();
/* The row pointed to after calling moveToInsertRow() is a special row, a buffer, which you can use to build up the row, a buffer,
which you can use to build up the row until all column values has been set on the row. 
Once the row is ready to be inserted into the ResultSet, call the insertRow() method.    */

// ResultSet Holdability
/* The ResultSet Holdability determines if a resultSet is closed when the commit() method of the underlying connection is called.
Not all holdability modes are supported by all databases and JDBC drivers. The 
DatabaseMetaData.supportsResultSetHoldability(int holdability) returns true or false depending on whether the given holdability
mode is supported or not. */
// Ther are 2 types of holdability:
    ResultSet.CLOSE_CURSORS_OVER_COMMIT
    ResultSet.HOLD_CURSORS_OVER_COMMIT

The CLOSE_CURSORS_OVER_COMMIT holdability means that all ResultSet instances are closed when connection.commit() method is called
on the connections that created the ResultSet.

The HOLD_CURSORS_OVER_COMMIT holdability means that the ResultSet is kept open when the connection.commit() method is called on
the connection that created the ResultSet.

The HOLD_CURSORS_OVER_COMMIT holdability might be useful if you use the ResultSet to update values in the database. Thus, you can
open a ResultSet, update rows in it, call connection.commit() and still keep the same ResultSet open for future transactions on
the same rows.