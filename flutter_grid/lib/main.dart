import 'package:flutter/material.dart';

void main() => runApp(new MaterialApp(
      theme: ThemeData(
        primaryColor: Colors.tealAccent,
      ),
      home: MyApp(),
    ));

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  double slidervalue = 1.0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      backgroundColor: Colors.teal,
      appBar: AppBar(
          title: new Slider(
              divisions: 3,
              min: 1.0,
              max: 3.0,
              activeColor: Colors.red,
              value: slidervalue,
              onChanged: (double value) {
                setState(() {
                  slidervalue = value;
                });
                print(slidervalue);
              })),
      body: GridView.count(
        crossAxisCount: slidervalue.toInt(),
        childAspectRatio: 16.0 / (slidervalue * 10.0),
        children: <Widget>[
          Card(
            child: Center(
              child: new Text("Data"),
            ),
          ),
          Card(
            child: Center(
              child: new Text("Data"),
            ),
          ),
          Card(
            child: Center(
              child: new Text("Data"),
            ),
          ),
          Card(
            child: Center(
              child: new Text("Data"),
            ),
          ),
          Card(
            child: Center(
              child: new Text("Data"),
            ),
          ),
          Card(
            child: Center(
              child: new Text("Data"),
            ),
          ),
          Card(
            child: Center(
              child: new Text("Data"),
            ),
          ),
          Card(
            child: Center(
              child: new Text("Data"),
            ),
          ),
          Card(
            child: Center(
              child: new Text("Data"),
            ),
          ),
          Card(
            child: Center(
              child: new Text("Data"),
            ),
          ),
          Card(
            child: Center(
              child: new Text("Data"),
            ),
          ),
        ],
      ),
    );
  }
}
