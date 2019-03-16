import 'dart:ui' as ui;
import 'package:flutter/material.dart';
import 'package:google_maps_flutter/google_maps_flutter.dart';



class EightFragment extends StatelessWidget {
  static const String routeName = "/eight_fragment";

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    GoogleMapController.init();
    final size = MediaQueryData.fromWindow(ui.window).size;
    final GoogleMapOverlayController controller =
    //GoogleMapOverlayController.fromSize(width: 300.0, height: 200.0);
    GoogleMapOverlayController.fromSize(
      width: size.width,
      height: size.height - 72.0,
    );
    final mapController = controller.mapController;
    final Widget mapWidget = GoogleMapOverlay(controller: controller);
    return new MaterialApp(
      home: new Scaffold(
        appBar: AppBar(
           actions: <Widget>[
            IconButton(
              icon: const Icon(Icons.my_location),
              onPressed: () {
                final location = LatLng(24.934163, 67.044612);
                mapController.markers.clear();
                mapController.addMarker(MarkerOptions(
                  position: location,
                  icon: BitmapDescriptor.fromAsset('images/branch_map.png'),
                ));
                mapController.animateCamera(
                  CameraUpdate.newLatLngZoom(
                      location, 15.0),
                );
              },
            ),
          ],
        ),
        body: MapsDemo(mapWidget, controller.mapController),
        floatingActionButton: FloatingActionButton(
          onPressed: () {},
          child: const Icon(Icons.my_location),
        ),
      ),
      navigatorObservers: <NavigatorObserver>[controller.overlayController],
    );

  }
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
class MapsDemo extends StatelessWidget {
  MapsDemo(this.mapWidget, this.controller);

  final Widget mapWidget;
  final GoogleMapController controller;

  @override
  Widget build(BuildContext context) {
    return Center(child: mapWidget);
  }
}
