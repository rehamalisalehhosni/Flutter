import 'package:flutter/material.dart';

void main() => runApp(new MaterialApp(
      home: MyApp(),
    ));

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> with SingleTickerProviderStateMixin {
  AnimationController animationController;
  double size = 100.0;
  Animation<double> animation;
  Animation<Color> animationColor;
  ColorTween colorTween2;
  @override
  void initState() {
    super.initState();
    animationController = AnimationController(
        vsync: this,
        duration: Duration(seconds: 3));
    Tween<double> tween = Tween<double>(begin: 100.0, end: 300.0);
    ColorTween colorTween=ColorTween(begin: Colors.red,end: Colors.amberAccent);
     colorTween2=ColorTween(begin: Colors.greenAccent,end: Colors.pinkAccent);
    animationColor = colorTween.animate(animationController)..addListener(() {
      setState(() {
      });
    });
    animation = tween.animate(animationController)..addListener(() {
      setState(() {
        size = animation.value;
      });
    });
    animationController.forward();

  }

  @override
  void dispose() {
    animationController.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      body: Container(
        color: colorTween2.evaluate(animation),
        child: Center(
          child: Container(
            color: animationColor.value,
            height: size ,
            width: size,
          ),
        ),
      ),
    );
  }
}
