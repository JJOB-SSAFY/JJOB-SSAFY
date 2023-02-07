// import firebase from 'firebase/compat/app';
// import 'firebase/compat/auth';
// import 'firebase/compat/firestore';
// import 'firebase/compat/storage';

import { initializeApp } from 'firebase/app';
import { getStorage } from 'firebase/storage';

const firebaseConfig = {
  apiKey: 'AIzaSyCZi20Y-QSc2QiFAPygYz75qFLfO2DR1WM',
  authDomain: 'jjob-4c01e.firebaseapp.com',
  projectId: 'jjob-4c01e',
  storageBucket: 'jjob-4c01e.appspot.com',
  messagingSenderId: '612674225506',
  appId: '1:612674225506:web:cbde13f270ecebcfd1183b',
  measurementId: 'G-M91MH1ZYPX',
};

const app = initializeApp(firebaseConfig);
export const storage = getStorage(app);
export default app;
