/*Please add ; after each select statement*/
CREATE PROCEDURE volleyballResults()
BEGIN
	select * from results
    order by wins;
END