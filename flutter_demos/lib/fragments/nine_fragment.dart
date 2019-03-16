import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter_demos/fragments/animate_camera.dart';
import 'package:flutter_demos/fragments/map_ui.dart';
import 'package:flutter_demos/fragments/move_camera.dart';
import 'package:flutter_demos/fragments/page.dart';
import 'package:flutter_demos/fragments/place_marker.dart';
import 'package:flutter_demos/fragments/scrolling_map.dart';


const API_KEY = "AIzaSyBSPcOuFWRs4qpUvtw4QgoLF2IDUr3Ihjo";


/*class NineFragment extends StatelessWidget {
  static const String routeName = "/fifth_fragment";

  @override
  Widget build(BuildContext context) {
    // TODO: implement build
    return new Center(
      child: MyApp(),
    );
  }

}*/

/*
class MyApp extends StatefulWidget {
  @override
  _MyAppState createState() => _MyAppState();
}

class _MyAppState extends State<MyApp> {
  GoogleMapController mapController;

  final LatLng _center = const LatLng(45.521563, -122.677433);

  void _onMapCreated(GoogleMapController controller) {
    mapController = controller;
  }

  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      home: Scaffold(
        body: GoogleMap(
          onMapCreated: _onMapCreated,
          options: GoogleMapOptions(
            cameraPosition: CameraPosition(
              target: _center,
              zoom: 11.0,
            ),
          ),
        ),
      ),
    );
  }
}*/


final List<Page> _allPages = <Page>[
  MapUiPage(),
  AnimateCameraPage(),
  MoveCameraPage(),
  PlaceMarkerPage(),
  ScrollingMapPage(),
];

class NineFragment extends StatelessWidget {
  void _pushPage(BuildContext context, Page page) {
    Navigator.of(context).push(MaterialPageRoute<void>(
        builder: (_) => Scaffold(
          appBar: AppBar(title: Text(page.title)),
          body: page,
        )));
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(title: const Text('GoogleMaps examples')),
      body: ListView.builder(
        itemCount: _allPages.length,
        itemBuilder: (_, int index) => ListTile(
          leading: _allPages[index].leading,
          title: Text(_allPages[index].title),
          onTap: () => _pushPage(context, _allPages[index]),
        ),
      ),
    );
  }
}



