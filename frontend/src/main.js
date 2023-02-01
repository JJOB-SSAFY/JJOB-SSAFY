import { createApp, h } from 'vue';
import App from './App.vue';
import router from './router/vue-router';
import store from './store';

import 'bootstrap';
import './index.css';
import './assets/main.css';

const app = createApp({
	render: () => h(App),
});
app.use(store);
app.use(router);

app.mount('#app');
