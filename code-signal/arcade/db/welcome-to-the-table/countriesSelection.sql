/*Please add ; after each select statement*/
CREATE PROCEDURE countriesSelection()
BEGIN
	select * from countries
    where continent = 'Africa'
    order by name;
END