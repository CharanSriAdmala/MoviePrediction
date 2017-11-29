using periodic commit
load csv with headers from "file:///C:/movie_dataset.csv" as row
create (m:Movies{title:row.movie_title, duration:row.duration, gross:row.gross, imdb:row.imdb_score, budget:row.budget, year:row.title_year});

using periodic commit
load csv with headers from "file:///C:/cast.csv" as row
create (cc:CastCrew{name:row.name});

using periodic commit
load csv with headers from "file:///C:/movie_cast1.csv" as row
WITH row
merge (m:Movies{title:row.movie})
merge (cc:CastCrew{name:row.Cast})
create (cc)-[:PART{role:row.Role}]->(m)

using periodic commit
load csv with headers from "file:///C:/movie_cast2.csv" as row
WITH row
merge (m:Movies{title:row.movie})
merge (cc:CastCrew{name:row.cast})
create (cc)-[:PART{role:row.Role}]->(m)

using periodic commit
load csv with headers from "file:///C:/movie_cast3.csv" as row
WITH row
merge (m:Movies{title:row.movie})
merge (cc:CastCrew{name:row.cast})
create (cc)-[:PART{role:row.Role}]->(m)

using periodic commit
load csv with headers from "file:///C:/movie_cast4.csv" as row
WITH row
merge (m:Movies{title:row.movie})
merge (cc:CastCrew{name:row.cast})
create (cc)-[:PART{role:row.Role}]->(m)

using periodic commit
load csv with headers from "file:///C:/country.csv" as row
create (o:Origin{country:row.country});

using periodic commit
load csv with headers from "file:///C:/movie_origin.csv" as row
WITH row
merge (m:Movies{title:row.movie})
merge (o:Origin{country:row.Origin})
create (m)-[:FROM{language:row.From}]->(o);

using periodic commit
load csv with headers from "file:///C:/CSV/genre.csv" as row
create (g:Genre{name:row.genre});

using periodic commit
load csv with headers from "file:///C:/Movie_genre.csv" as row
WITH row
merge (m:Movies{title:row.movie_title})
merge (g:Genre{name:row.genre})
create (m)-[:OF]->(g);

using periodic commit
load csv with headers from "file:///C:/user.csv" as row
create (u:User{id:row.UserID});

using periodic commit
load csv with headers from "file:///C:/movie_user.csv" as row
WITH row
merge (m:Movies{title:row.Title})
merge (u:User{id:row.userId})
create (u)-[:RATED{rating:row.rating}]->(m);
