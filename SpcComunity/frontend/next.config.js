/** @type {import('next').NextConfig} */
const path = require('path')

const nextConfig = {
  reactStrictMode: true,
  async rewrites() {
    return [
      {
        destination: 'http://127.0.0.1:9999/api/:path*',
        source: '/api/:path*',
      },
      {
        destination: 'http://127.0.0.1:9999/auth/:path*',
        source: '/auth/:path*',
      }
    ]
  },
  sassOptions: {
    includePaths: [path.join(__dirname, 'styles')],
  },
}

module.exports = nextConfig
