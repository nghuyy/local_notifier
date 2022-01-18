# local_notifier

[![pub version][pub-image]][pub-url] [![][discord-image]][discord-url]

[pub-image]: https://img.shields.io/pub/v/local_notifier.svg
[pub-url]: https://pub.dev/packages/local_notifier

[discord-image]: https://img.shields.io/discord/884679008049037342.svg
[discord-url]: https://discord.gg/zPa6EZ2jqb

This plugin allows Flutter **desktop** apps to displaying local notifications.

---


## Quick Start

### Installation

Add this to your package's pubspec.yaml file:

```yaml
dependencies:
  git:
   url:
   ref: main
```


#### ⚠️ Linux requirements

- `libnotify`

Run the following command

```
sudo apt-get install libnotify-dev
```

### Usage

```dart
LocalNotification notification = LocalNotification(
  title: "local_notifier_example",
  subtitle: "subtitle",
  body: "hello flutter!",
);
await localNotifier.notify(notification);
```

> Please see the example app of this plugin for a full example.

## Who's using it?

- [Biyi (比译)](https://biyidev.com/) - A convenient translation and dictionary app.

## API

### LocalNotifier

| Method   | Description                                     | Linux | macOS | Windows |
| -------- | ----------------------------------------------- | ----- | ----- | ------- |
| `notify` | Immediately shows the notification to the user. | ✔️     | ✔️     | ✔️       |

## Related Links

- https://github.com/mohabouje/WinToast

## License

[MIT](./LICENSE)
