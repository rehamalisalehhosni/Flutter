import 'package:flutter/material.dart';

void main() => runApp(new MaterialApp(
      home: MyApp(),
    ));

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(),
      body: Wrap(
        crossAxisAlignment: WrapCrossAlignment.center,
        spacing: 10.0,
        children: <Widget>[
          Chip(label: new Text("Data")),
          Chip(label: new Text("Data")),
          Chip(label: new Text("Data")),
          Chip(label: new Text("Data")),
          Chip(label: new Text("Data"),avatar: Icon(Icons.face),),
          Chip(label: new Text("Data"),onDeleted: (){},deleteIcon: Icon(Icons.close),),
          Chip(label: new Text("Data")),
          Chip(label: new Text("Data")),
        ],
      ),

      /*Center(
*/ /*        child: Container(
          constraints: BoxConstraints(
            minHeight: 100.0,
            minWidth: 100.0
          ),
          color: Colors.red,
          width: 200.0,
          height: 50.0,

        ),*/ /*
        child: Container (
          constraints: BoxConstraints(
              minHeight: 100.0,
              minWidth: 100.0,
              maxHeight: 200.0,
              maxWidth: 200.0),
          child: Stack(
            fit: StackFit.loose,
            overflow: Overflow.visible,
            alignment: Alignment.topRight,
            textDirection: TextDirection.ltr,
            children: <Widget>[
              Container(
                color: Colors.red,
                width: 200.0,
                height: 200.0,
              ),
              Positioned(
                left: 50.0,
                top: -10.0,
                child: Container(
                  color: Colors.green,
                  width: 100.0,
                  height: 100.0,
                ),
              ),
              Container(
                color: Colors.yellow,
                width: 50.0,
                height: 50.0,
              )
            ],
          ),
        ),
      ),*/
    );
  }
}
