import 'package:flutter/material.dart';

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return MaterialApp(
        home: new Scaffold(
      appBar: AppBar(title: new Row(
        children: <Widget>[
          new Icon(Icons.home),
          new Text('first app'),
        ],
      )),
      body: new Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
          _Card("first",Icons.ac_unit, mycolor: Colors.amberAccent),
          _Card("sec",Icons.access_alarms,mycolor: Colors.purple),
          _Card("third",Icons.account_balance),

        ],
      ),
    ));
  }

  Card _Card(String mytext , IconData myicon ,{Color mycolor:Colors.redAccent}) {
    return new Card(child: Padding(
      padding: const EdgeInsets.all(18.0),
      child: Row(
        mainAxisAlignment: MainAxisAlignment.center,
        children: <Widget>[
            new Icon(myicon,size: 50.0,color: mycolor ,),
            new Text(mytext,style: new TextStyle(fontSize: 20.0),),
          ],),
    ),);
  }
}
