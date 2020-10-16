import 'package:flutter/material.dart';
import 'package:whatsapp_ui/models/call_model.dart';

class CallsScreen extends StatefulWidget{
  @override
  State<StatefulWidget> createState() {
    return new CallsScreenState();
  }
}

class CallsScreenState extends State<CallsScreen>{

  void image(Image image){
  }

  @override
  Widget build(BuildContext context) {
    return new ListView.builder(
      itemCount: dummy_data.length,
      itemBuilder: (context,i)=> new Column(
        children: <Widget>[
          new ListTile(
            leading: new CircleAvatar(
              foregroundColor: Theme.of(context).primaryColor,
              backgroundColor: Colors.grey,
              backgroundImage: new NetworkImage(dummy_data[i].avatarUrl),
            ),
            title: new Row(
              mainAxisAlignment: MainAxisAlignment.spaceBetween,
              children: <Widget>[
                new Text(dummy_data[i].name, style: new TextStyle(fontWeight: FontWeight.bold)),
              ],
            ),
            subtitle: new Container(
              padding: new EdgeInsets.only(top: 5.0),
              child: new Container(
                child: new Row(
                  children: <Widget>[
                    new Container(
                      height: 15.0,
                      width: 15.0,
                      child: new Image(image:new AssetImage(dummy_data[i].call_detail)),
                    ),
                    new Padding(padding: new EdgeInsets.only(right: 5.0)),
                    new Text(dummy_data[i].message, style:new TextStyle(color: Colors.grey,fontSize: 15.0)),
                  ],
                ),
              ),
            ),
            trailing: new Container(
              height: 22.0,
              width: 22.0,
              child: new Image(image:new AssetImage(dummy_data[i].type_call)),
            )
          ),
          new Divider(
            height: 10.0,
          ),
        ],
      ),
    );
  }

}