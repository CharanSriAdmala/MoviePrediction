using periodic commit
load csv with headers from "file:///C:/CSV/.csv" as row
create (m:Movies{title:row.movie_title, duration:row.duration, gross:row.gross, imdb:row.imdb_score, budget:row.budget});

using periodic commit
load csv with headers from "file:///C:/CSV/.csv" as row
create (cc:CastCrew{name:row.name});

using periodic commit
load csv with headers from "file:///C:/CSV/.csv" as row
match (m:Movies{title:row.movie_title})
match (cc:CastCrew{name:row.name})
merge (cc)-[:PART{role:row.}]->(m)

using periodic commit
load csv with headers from "file:///C:/CSV/.csv" as row
create (o:Origin{country:row.country});

using periodic commit
load csv with headers from "file:///C:/CSV/.csv" as row
match (m:Movies{title:row.movie_title})
match (o:Origin{country:row.country})
merge (m)-[:FROM{language:row.language}]->(o);

using periodic commit
load csv with headers from "file:///C:/CSV/genre.csv" as row
create (g:Genre{name:row.genre});

using periodic commit
load csv with headers from "file:///C:/CSV/.csv" as row
match (m:Movies{title:row.movie_title})
match (g:Genre{name:row.})
merge (m)-[:OF]->(g);

using periodic commit
load csv with headers from "file:///C:/CSV/.csv" as row
create (u:User{id:row.id});

using periodic commit
load csv with headers from "file:///C:/CSV/.csv" as row
match (m:Movies{title:row.movie_title})
match (u:User{id:row.id})
merge (u)-[:RATED{rating:row.rating}]->(m);

