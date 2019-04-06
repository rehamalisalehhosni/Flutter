import 'package:flutter/material.dart';

void main() => runApp(new MaterialApp(home: MyApp(),));

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  double size =200.0;
  @override
  Widget build(BuildContext context) {
    return new Center(
      child: GestureDetector(
        onTap: (){
          setState(() {
            this.size=400.0;
          });
        },
        child: AnimatedContainer(
          duration: Duration(seconds: 3),
          width: size,
          height: size ,
          color: Colors.red,
        ),
      ),
    );
  }
}
