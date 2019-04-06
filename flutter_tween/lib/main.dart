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
  Animation<Alignment> alignmentAnimetion;

  @override
  void initState() {
    super.initState();
    animatecontroller =
        AnimationController(vsync: this, duration: Duration(seconds: 3));
    final curveAnimation =
        CurvedAnimation(parent: animatecontroller, curve: Curves.linear);
    final align1 = AlignmentTween(begin: Alignment.topCenter, end: Alignment.bottomCenter);
    final align2 = AlignmentTween(begin: Alignment.bottomCenter, end: Alignment.bottomLeft);
    final align3 = AlignmentTween(begin: Alignment.bottomLeft, end: Alignment.centerLeft);
    final align4 = AlignmentTween(begin: Alignment.centerLeft, end: Alignment.centerRight);
    final alignSec=TweenSequence<Alignment>(
      [
        TweenSequenceItem(tween: align1,weight: 3.0),
        TweenSequenceItem(tween: align2,weight: 1.0),
        TweenSequenceItem(tween: align3,weight: 1.0),
        TweenSequenceItem(tween: align4,weight: 1.0),
      ]
    );
    alignmentAnimetion = alignSec.animate(curveAnimation);
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
              AnimatedBuilder(
                child: Container(
                  width: 100.0,
                  height: 100.0,
                  decoration:
                      BoxDecoration(color: Colors.red, shape: BoxShape.circle),
                ),
                builder: (BuildContext context, Widget child) {
                  return Align(
                    alignment: alignmentAnimetion.value,
                    child: child,
                  );
                },
                animation: alignmentAnimetion,
              ),
            ],
          ),
        ),
      ),
    );
  }
}
