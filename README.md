# uri-escape

This is a small library that will percent encode your data according to [rfc3986](https://tools.ietf.org/html/rfc3986#section-2.2).

## Usage

```clojure
(require '[uri-escape.core :as esc])

;; later

(esc/encode "hello world!")     ;; => "hello%20world%21"
(esc/decode "hello%20world%21") ;; => "hello world!"
```

## License

[![License: Artistic-2.0](https://img.shields.io/badge/License-Artistic%202.0-0298c3.svg)](https://opensource.org/licenses/Artistic-2.0)
