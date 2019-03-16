import 'package:flutter/material.dart';
import 'package:plants/Routes.dart';
import 'package:plants/ui/home/HomePage.dart';

void main() {
  Routes.initRoutes();
  runApp(new MaterialApp(
    title: "Planets",
    home: new HomePage(),
  ));
}





