import pyttsx3 as pt 
engine=pt.init()
voices=engine.getProperty('voices')
rate=engine.getProperty('rate')
engine.setProperty('pitch',0.8)
engine.setProperty('voices',voices[1].id)
engine.setProperty('rate',140)
print("<<<<<Convert your text into MP3>>>>>\n")
file=input("Enter your text to listen:")
path=r'D:\all codes\New folder\mixed\python codes\voice.mp3'
engine.say(file)
engine.save_to_file(file,path)
engine.runAndWait()
engine.stop()