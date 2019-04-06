import 'package:flutter/material.dart';

void main() =>
    runApp(new MaterialApp(
      home: new MyApp(),
    ));

class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> with SingleTickerProviderStateMixin {
  AnimationController animatecontroller;
  double size = 100.0;
  Animation <double> sizeAnimation;
  @override
  void initState() {
    super.initState();
    animatecontroller =
        AnimationController(vsync: this, duration: Duration(seconds: 3));
    final curveAnimation = CurvedAnimation(
        parent: animatecontroller, curve: Curves.bounceOut);
     sizeAnimation = Tween<double>(begin: 100.0, end: 300.0).animate(
        curveAnimation);
    animatecontroller.forward();
    sizeAnimation.addListener(() {
      setState(() {
        size = sizeAnimation.value;
      });
    }
    );
  }

  @override
  void dispose() {
    animatecontroller.dispose();
    super.dispose();
  }

  @override
  Widget build(BuildContext context) {
    return new Scaffold(
      body: new Container(
        color: Colors.brown,
        child: Center(
            child: AnimateCircle(animation: sizeAnimation)
        ),
      ),
    );
  }
}

class AnimateCircle extends AnimatedWidget {
  AnimateCircle({
    Animation<double> animation
  }) :super(listenable: animation);

  @override
  Widget build(BuildContext context) {
    final Animation<double>  animation=listenable;
    // TODO: implement build
    return new Container(
      width: animation.value,
      height: animation.value,
      decoration: BoxDecoration(
          color: Colors.greenAccent, shape: BoxShape.circle),
    );
  }

}