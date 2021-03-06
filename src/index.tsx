import { NativeModules, Platform } from 'react-native';

const LINKING_ERROR =
  `The package 'react-native-user-interface' doesn't seem to be linked. Make sure: \n\n` +
  Platform.select({ ios: "- You have run 'pod install'\n", default: '' }) +
  '- You rebuilt the app after installing the package\n' +
  '- You are not using Expo managed workflow\n';

const UserInterface = NativeModules.UserInterface
  ? NativeModules.UserInterface
  : new Proxy(
      {},
      {
        get() {
          throw new Error(LINKING_ERROR);
        },
      }
    );

export function setUserInterface(style: 'dark' | 'light' | 'unspecified') {
  UserInterface.setUserInterface(style);
}
