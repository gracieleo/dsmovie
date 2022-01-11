/* Arquivo principal da aplicação React */

import React from 'react';
import ReactDOM from 'react-dom';
import App from './App';
import 'bootstrap/dist/css/bootstrap.css';
import './index.css';


ReactDOM.render(                  /**renderiza o que está em App e envia para o HTML 'root' */
  <React.StrictMode>
    <App />
  </React.StrictMode>,
  document.getElementById('root')
);

