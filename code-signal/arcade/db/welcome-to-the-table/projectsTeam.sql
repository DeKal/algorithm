/*Please add ; after each select statement*/
CREATE PROCEDURE projectsTeam()
BEGIN
	select distinct name from projectLog order by name;
END