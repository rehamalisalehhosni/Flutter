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
  Animation<Alignment> alignAnimation;
  Animation<BorderRadius> radusAnimation;
  Animation<double> WidthAnimation;
  Animation<double> heightAnimation;
  @override
  void initState() {
    super.initState();
    animatecontroller =
        AnimationController(vsync: this, duration: Duration(seconds: 10))..addListener((){
          setState(() { });
        });
    alignAnimation =Tween<Alignment>(begin: Alignment.topCenter,end: Alignment.bottomCenter)
        .animate(CurvedAnimation(parent: animatecontroller, curve: Interval(0.0, 0.20,curve: Curves.bounceOut) ));
    radusAnimation =BorderRadiusTween(begin: BorderRadius.circular(50.0),end:  BorderRadius.circular(0.0))
        .animate(CurvedAnimation(parent: animatecontroller, curve: Interval(0.20, 0.40,curve: Curves.fastOutSlowIn) ));
    WidthAnimation =Tween<double>(begin: 100.0,end: 300.0)
        .animate(CurvedAnimation(parent: animatecontroller, curve: Interval(0.40, 0.70,curve: Curves.linear) ));
    heightAnimation =Tween<double>(begin: 100.0,end: 500.0)
        .animate(CurvedAnimation(parent: animatecontroller, curve: Interval(0.70, 1.00,curve: Curves.elasticOut) ));
  }
  @override
  void dispose() {
    animatecontroller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Container(
        color: Colors.white,
        child: GestureDetector(
          onTap: () {
            animatecontroller.forward();
          },
          child: Stack(
            children: <Widget>[
              Align(
                alignment: alignAnimation.value,
                child: Container(
                  width: WidthAnimation.value,
                  height: heightAnimation.value,
                  decoration:
                  BoxDecoration(color: Colors.red, borderRadius: radusAnimation.value),
                ),
              )
            ],
          ),
        ),
      ),
    );
  }
}
