import 'package:flutter/material.dart';

void main() => runApp(new MaterialApp(
      home: MyApp(),
    ));

class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      appBar: new AppBar(
        title: new Text("text"),
      ),
      body: new Container(
        height: 100.0,
        child: new ListView(
          scrollDirection: Axis.horizontal,
          children: <Widget>[
            new Container(
              width: 100.0,
              color: Colors.red,
            ),
            new Container(
              width: 100.0,
              color: Colors.yellow,
            ),
            new Container(
              width: 100.0,
              color: Colors.green,
            ),
            new Container(
              width: 100.0,
              color: Colors.blue,
            ),
            new Container(
              width: 100.0,
              color: Colors.purple,
            ),
            new Container(
              width: 100.0,
              color: Colors.pinkAccent,
            ),
            new SizedBox(width: 20.0,),
            new CircleAvatar(
              radius: 50.0,
              backgroundColor: Colors.red,
              child: new Text("Data"),
              foregroundColor: Colors.red,
              backgroundImage: NetworkImage("https://www.elastic.co/assets/bltada7771f270d08f6/enhanced-buzz-1492-1379411828-15.jpg"),
            ),
          ],
        ),

      ),
    );
  }
}
