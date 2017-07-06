'use strict';

// tag::vars[]
const React = require('react');
const ReactDOM = require('react-dom')
import SimpleComponent from './js/TempSimpleComponent.js';
//import './bootstrap-3.3.7-dist/css/bootstrap.min.css';

// end::vars[]

// tag::app[]
class App extends React.Component {

	constructor(props) {
		super(props);
	}

	render() {
		return (
			<div>App rendered 1
			<SimpleComponent />
			</div>
		)
	}
}
// end::app[]

// tag::render[]
ReactDOM.render(
	<App />,
	document.getElementById('react')
)
// end::render[]