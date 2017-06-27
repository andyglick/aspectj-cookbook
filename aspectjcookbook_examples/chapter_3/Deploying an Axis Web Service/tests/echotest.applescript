tell application "http://localhost:9006/axis/services/MyWebService"
	call soap {method name:"echo", parameters:{arg1:"Hi"}}
end tell