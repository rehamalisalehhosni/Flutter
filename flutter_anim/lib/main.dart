import 'package:flutter/material.dart';
import 'dart:math' as math;
void main() => runApp(MaterialApp(
      home: MyApp(),
    ));

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  double sliderValue = 0.0;

  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(),
        body: new Column(
          children: <Widget>[
            Slider(
                value: sliderValue,
                min: 0.0,
                max: MediaQuery.of(context).size.width,
                onChanged: (newvalue) {
                  setState(() {
                    sliderValue = newvalue;
                  });
                }),
            Flexible(
              child: ListView(
                children: <Widget>[
                  Center(
                    child: Transform.rotate(
                      angle: sliderValue * math.pi / 180.0,
                      child: Container(
                        color: Colors.red,
                        width: 100.00,
                        height: 100.0,
                        child: Center(child: Text("Rotation")),
                      ),
                    ),
                  ),
                  SizedBox(
                    height: 50.0,
                    width: 50.0,
                  ),
                  Center(
                    child: Transform.scale(
                      scale: sliderValue/ MediaQuery.of(context).size.width,
                      child: Container(
                        color: Colors.green,
                        width: 100.00,
                        height: 100.0,
                        child: Center(child: Text("sacale")),
                      ),
                    ),
                  ),
                  SizedBox(
                    height: 50.0,
                    width: 50.0,
                  ),
                  Row(
                    children: <Widget>[
                      Transform.translate(
                        offset: Offset(sliderValue , 0.0),
                        child: Container(
                          color: Colors.blue,
                          width: 100.0,
                          height: 100.0,
                          child: Center(child: Text("transation")),
                        ),
                      ),
                    ],
                  ),
                ],
              ),
            )
          ],
        ));
  }
}
