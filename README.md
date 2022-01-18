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


## API

### LocalNotifier

| Method   | Description                                     | Linux | macOS | Windows | Anroid
| -------- | ----------------------------------------------- | ----- | ----- | ------- | -------|
| `notify` | Immediately shows the notification to the user. | ✔️     | ✔️     | ✔️       | ✔️ |

## Related Links

- https://github.com/mohabouje/WinToast

## License

[MIT](./LICENSE)
