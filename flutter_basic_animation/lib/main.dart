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

  @override
  void initState() {
    super.initState();
    animationController = AnimationController(
        vsync: this,
        duration: Duration(seconds: 3),
        lowerBound: 50.0,
        upperBound: 300.0);
    //animationController.forward();
    animationController.addListener(() {
      setState(() {});
    });
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
        color: Colors.brown,
        child: Center(
          child: GestureDetector(
            onTap: () {
              if (animationController.status == AnimationStatus.completed) {
                animationController.reverse();
              } else if (animationController.status ==AnimationStatus.dismissed) {
                animationController.forward();
              }
            },
            child: FlutterLogo(
              size: animationController.value,
            ),
          ),
        ),
      ),
    );
  }
}
