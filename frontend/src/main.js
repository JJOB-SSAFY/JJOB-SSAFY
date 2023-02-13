import { createApp } from 'vue';
import App from './App.vue';
import router from './router/vue-router';
import store from './store';
import VueCookies from 'vue-cookies';

// Vuetify

import BootstrapVueNext from 'bootstrap-vue-next';

import 'bootstrap/dist/css/bootstrap.min.css';
import 'bootstrap/dist/css/bootstrap.css';
import 'bootstrap-vue-next/dist/bootstrap-vue-next.css';
import './index.css';
import './assets/main.css';

/* import the fontawesome core */
import { library } from '@fortawesome/fontawesome-svg-core';

/* import font awesome icon component */
import { FontAwesomeIcon } from '@fortawesome/vue-fontawesome';
import { fas } from '@fortawesome/free-solid-svg-icons';
import { far } from '@fortawesome/free-regular-svg-icons';
import { fab } from '@fortawesome/free-brands-svg-icons';

import 'vuetify/styles';
import { createVuetify } from 'vuetify';
import * as components from 'vuetify/components';
import * as directives from 'vuetify/directives';

const vuetify = createVuetify({
	components,
	directives,
});
/* add icons to the library */
library.add(fas, far, fab);

let app = createApp(App);
app.use(BootstrapVueNext);
app.use(router);
app.use(store);
app.use(VueCookies);
app.use(vuetify);
app.component('fa-icon', FontAwesomeIcon).mount('#app');
