var path = require('path');
var webpack = require('webpack');
var packageJSON = require('./package.json');

module.exports = {
    entry: './src/main/resources/static/App.js',
    devtool: 'sourcemaps',
    cache: true,
//    debug: true,
    output: {
        path: __dirname,
        filename: './src/main/resources/static/built/bundle.js'
    },
    resolve: {extensions: ['.js', '.jsx']},
    plugins: [
               new webpack.HotModuleReplacementPlugin()
               ,new webpack.LoaderOptionsPlugin({
                     debug: true
                   })
        ],
    module: {
        loaders: [
            {
                test: path.join(__dirname, '.'),
                exclude: /(node_modules)/,
                loader: 'babel-loader',
                query: {
                    cacheDirectory: true,
                    presets: ['es2015', 'react']
                }
            },

        ]
    },
    devServer: {
            noInfo: false,
            quiet: false,
            lazy: false,
            watchOptions: {
                poll: true
           }
        }
};