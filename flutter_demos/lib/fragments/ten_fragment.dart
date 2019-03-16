import 'dart:async';

import 'package:flutter/material.dart';
import 'package:flutter_map/flutter_map.dart';
import 'package:latlong/latlong.dart';

const API_KEY = "AIzaSyBSPcOuFWRs4qpUvtw4QgoLF2IDUr3Ihjo";

class TenFragment extends StatelessWidget {
  static const String routeName = "/ten_fragment";

  @override

  Widget build(BuildContext context) {
    return new MaterialApp(
      home: new Scaffold(
        body: new FlutterMap(
            options:
            new MapOptions(
              center: new LatLng(40.71, -74.00),
              minZoom: 10.0,
            ),
          layers: [
            new TileLayerOptions(
            urlTemplate:
            "https://{s}.tile.openstreetmap.org/{z}/{x}/{y}.png",
            subdomains: ['a', 'b', 'c']),
            new MarkerLayerOptions(markers: [
              new Marker(
                  width: 45.0,
                  height: 45.0,
                  point: new LatLng(40.73, -74.00),
                  builder: (context) => new Container(
                    child: IconButton(
                      icon: new Image.asset('images/branch_map.png'),
                      color: Colors.red,
                      iconSize: 45.0,
                      onPressed: () {
                        print('Marker tapped');
                      },
                    ),
                  )),
              new Marker(
                  width: 45.0,
                  height: 45.0,
                  point: new LatLng(40.73, -73.00),
                  builder: (context) => new Container(
                    child: IconButton(
                      icon: Icon(Icons.location_on),
                      color: Colors.red,
                      iconSize: 45.0,
                      onPressed: () {
                        print('Marker tapped');
                      },
                    ),
                  )),

            ])
          ],
        ),
      ),
    );

  }
}

