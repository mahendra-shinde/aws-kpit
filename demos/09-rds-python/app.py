## pip install mysql-connector-python

import mysql.connector

host = "database-1.cimr0kdyqj64.us-east-1.rds.amazonaws.com"
user = "admin"
password = "Pass$123456"
database = "sample"

try:
    connection = mysql.connector.connect(
        host=host,
        user=user,
        password=password,
        database=database
    )
    if connection.is_connected():
        print("Connected to the database")
        # Create a cursor
        cursor = connection.cursor()

        # Execute SQL queries
        cursor.execute("SELECT * FROM country")
        rows = cursor.fetchall()

        # Process the result
        for row in rows:
            print(row)

except mysql.connector.Error as err:
    print(f"Error: {err}")

finally:
    # Close the cursor and connection
    if 'cursor' in locals():
        cursor.close()
    if 'connection' in locals() and connection.is_connected():
        connection.close()
        print("Connection closed")


