# local_notifier


### Installation

Add this to your package's pubspec.yaml file:

```yaml
dependencies:
  git:
   url: https://github.com/nghuyy/local_notifier.git
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
