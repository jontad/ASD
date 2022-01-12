compileUser:
	javac User.java 

compileMain:
	javac Main.java

user: compileUser
	java User

main: compileMain
	java Main
	

