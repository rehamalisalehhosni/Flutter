import 'package:flutter_demos/pages/home_page.dart';
import 'package:flutter/material.dart';
//import 'package:map_view/map_view.dart';
import 'package:flutter_demos/fragments/first_fragment.dart';
import 'package:flutter_demos/fragments/second_fragment.dart';
import 'package:flutter_demos/fragments/third_fragment.dart';
import 'package:flutter_demos/fragments/fourth_fragment.dart';
import 'package:flutter_demos/fragments/fifth_fragment.dart';
import 'package:flutter_demos/fragments/six_fragment.dart';
import 'package:flutter_demos/fragments/seven_fragment.dart';
import 'package:flutter_demos/fragments/eight_fragment.dart';
import 'package:flutter_demos/fragments/nine_fragment.dart';
import 'package:flutter_demos/fragments/ten_fragment.dart';
import 'package:flutter_demos/fragments/eleven_fragment.dart';

// import 'package:map_view/map_view.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';

const API_KEY = "AIzaSyBSPcOuFWRs4qpUvtw4QgoLF2IDUr3Ihjo";

void main() {
//  GoogleMapController.init();
  //MapView.setApiKey(API_KEY);

  //MapsDemo(mapWidget, controller.mapController)
  //final GoogleMapOverlayController controller =
  //GoogleMapOverlayController.fromSize(width: 300.0, height: 200.0);
  //final Widget mapWidget = GoogleMapOverlay(controller: controller);
  runApp(MaterialApp(
    debugShowCheckedModeBanner: false,
    home: new Scaffold(
      body: MyApp(),
    ),

    //navigatorObservers: <NavigatorObserver>[controller.overlayController],
  ));
}

/*
class MapsDemo extends StatelessWidget {
  MapsDemo(this.mapWidget, this.controller);

  final Widget mapWidget;
  final GoogleMapController controller;

  @override
  Widget build(BuildContext context) {
    return Padding(
      padding: EdgeInsets.all(15.0),
      child: Column(
        mainAxisAlignment: MainAxisAlignment.spaceEvenly,
        children: <Widget>[
          Center(child: mapWidget),
          RaisedButton(
            child: const Text('Go to London'),
            onPressed: () {
              controller.animateCamera(CameraUpdate.newCameraPosition(
                const CameraPosition(
                  bearing: 270.0,
                  target: LatLng(51.5160895, -0.1294527),
                  tilt: 30.0,
                  zoom: 17.0,
                ),
              ));
            },
          ),
        ],
      ),
    );
  }
}
*/




class MyApp extends StatelessWidget {
  // This widget is the root of your application.
  @override
  Widget build(BuildContext context) {
    return new MaterialApp(
      title: 'NavigationDrawer Demo',
      theme: new ThemeData(
        primarySwatch: Colors.blue,
      ),
      home: new HomePage(),
    );
  }
}

