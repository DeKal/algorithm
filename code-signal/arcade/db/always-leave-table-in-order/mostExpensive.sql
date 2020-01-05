/*Please add ; after each select statement*/
CREATE PROCEDURE mostExpensive()
BEGIN
    select name from Products order by price * quantity desc, name asc limit 1;
END