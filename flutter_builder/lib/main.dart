import 'package:flutter/material.dart';
import 'dart:math' as math;

void main() => runApp(new MaterialApp(
      home: new MyApp(),
    ));

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> with SingleTickerProviderStateMixin {
  AnimationController animatecontroller;
  CurvedAnimation curvedAnimation;
  double size = 100.0;

  @override
  void initState() {
    super.initState();
    animatecontroller =
        AnimationController(vsync: this, duration: Duration(seconds: 3));
    curvedAnimation =
        CurvedAnimation(parent: animatecontroller, curve: Curves.fastOutSlowIn);
    /*curvedAnimation.addListener(() {
      setState(() {});
    });*/
    animatecontroller.addStatusListener((status) {
      if (AnimationStatus.completed == status) {
        animatecontroller.reverse();
      } else if (AnimationStatus.dismissed == status) {
        animatecontroller.forward();
      }
    });
    animatecontroller.forward();
  }

  @override
  void dispose() {
    animatecontroller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return Container(
      color: Colors.deepPurpleAccent,
      child: Center(
        child: AnimatedBuilder(animation: curvedAnimation,
            child:Container(
              width: 200.0,
              height: 200.0,
              color: Colors.greenAccent,
            ),
            builder: (BuildContext context, Widget child) {
              return Transform.rotate(
                  angle: curvedAnimation.value * 2.0 * math.pi,
                  child: child
              );
            }),
      ),
    );

    /* return new Scaffold(
      body: new Container(
        color: Colors.brown,
        child: Center(
          child: Transform.rotate(
            angle: curvedAnimation.value * 2.0 * math.pi,
            child: Container(
              width: 200.0,
              height: 200.0,
              color: Colors.greenAccent,
            ),
          ),
        ),
      ),
    );*/
  }
}
