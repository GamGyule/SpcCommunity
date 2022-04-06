/** @type {import('next').NextConfig} */
const path = require('path')

const nextConfig = {
  reactStrictMode: true,
  async rewrites() {
    return [
      {
        destination: 'http://localhost:9999/api/:path*',
        source: '/api/:path*',
      }
    ]
  },
  sassOptions: {
    includePaths: [path.join(__dirname, 'styles')],
  },
}

module.exports = nextConfig
