IMPORTANT NOTE: Most of the dependencies for this project have been left out for simplicity. The purpose of this repository is to showcase my code for this project, and not necessarily to provide a working runnable project. Therefore, I have included my source code, a runnable jar file, and this README file (which includes hive qeuries that were used to answer various questions about wikipedia edit dump data that was used for the assignment). For further reference I have included the original project description for the assignment.


hbase org.apache.hadoop.hbase.mapreduce.ImportTsv -Dimporttsv.separator=',' -Dimporttsv.columns=HBASE_ROW_KEY,cf:fileid,cf:filename,cf:date,cf:username,cf:userid tab3 /wikiOut

CREATE EXTERNAL TABLE hivetab22(key INT, fileID INT, filename STRING, date INT, username STRING, userID STRING) STORED BY 'org.apache.hadoop.hive.hbase.HBaseStorageHandler' WITH SERDEPROPERTIES ("hbase.columns.mapping" = ":key,cf=fileid,cf:filename,cf:date,cf:username,cf:userid") TBLPROPERTIES("hbase.table.name" = "tab2");

Q1:

select filename, count(fileid) as ct from hivetab333 group by filename order by ct desc limit 10;

OUTPUT:

User:Lberlogos 1520
User:Tedius_Zanarukando 1340
User:MusicCitizen 1262
User:YUL89YYZ 1225
User:MistFitToys/List_of_celebrities_with_links_to_the_U.S._Republican_Party 1206
User:KF/For_future_reference 1183
User:vaoverland 1169
User:charles_Mathews/New_-_outher 1090
User:Reddi 1070
User:Blankfaze 1064

Q2:

select username, count(username) as ct from hivetab333 group by username order by ct desc limit 10;

OUTPUT:

Charles_Matthews 3362
Paul_August 3314
Blankfaze 2102
Antandrus 1845
KF 1791
MetsBot 1753
Chris_73 1633
Liberlogos 1576
Davidcannon 1530
Angela 1332

Q3:

select count(innerr.ct) from (select count(*) as ct from hivetab3333 group by filename having ct=1) as innerr;

OUTPUT: 5262

select count(inner.ct) from (select count(*) as ct from hivetab3333 group by filename) as innerr;

OUTPUT: 20436 

ANSER: 5262/20436*100 = 25.748%

Q4:

select count(innerr.ct) from (select count(*) as ct from hivetab3333 group by filename having ct>30) as innerr;

OUTPUT: 2890

ANSWER: 2890/20436*100 = 14.1417%

Q5:

select filename, count(fileid) as ct from hivetab333 where editdate='2008' group by filename order by ct desc limit 10;

OUTPUT:
User:PHG 46
User:Theresa_knott 14
User:Twilek 12
User:Fir002 11
User:Kesac 10
User:Jeandre_du_Toit 9
User:KF/for_future_reference 9
User:Tedius_zanarukando 8
User:Reddi 8
