from django.shortcuts import render
from django.views.decorators.csrf import csrf_exempt
from django.http import HttpResponse
import csv
import pandas as pd
import sqlite3

def home(request):
	return render(request,"recovery/header.html")

def get_servers(request):
	return render(request,"recovery/server_input.html")

def index(request):
	con = sqlite3.connect('/Users/ameen/Desktop/tecathon/dbcreate.db')
	cur = con.cursor()
	print("Opened database successfully");
	cur.execute("select * from adminupload")
	fields=['server_name','description','priority','status']
	data = cur.fetchall()

	cur.execute("SELECT s.server, a.priority from statustrack s, adminupload a where s.status='TODO' and s.end='null' and s.server=a.server order by a.priority DESC")
	TODOdata = cur.fetchall()

	cur.execute("SELECT s.server, a.priority from statustrack s, adminupload a where s.status='OS' and s.end='null' and s.server=a.server order by a.priority DESC")
	OSdata = cur.fetchall()

	cur.execute("SELECT s.server, a.priority from statustrack s, adminupload a where s.status='BACKUP' and s.end='null' and s.server=a.server order by a.priority DESC")
	BACKUPdata = cur.fetchall()

	cur.execute("SELECT s.server, a.priority from statustrack s, adminupload a where s.status='DATABASE' and s.end='null' and s.server=a.server order by a.priority DESC")
	DATABASEdata = cur.fetchall()

	cur.execute("SELECT s.server, a.priority from statustrack s, adminupload a where s.status='APPLICATION' and s.end='null' and s.server=a.server order by a.priority DESC")
	APPLICATIONdata = cur.fetchall()

	cur.execute("SELECT s.server, a.priority from statustrack s, adminupload a where s.status='DONE' and s.end='null' and s.server=a.server order by a.priority DESC")
	DONEdata = cur.fetchall()

	statusfields = ['TODO','OS','BACKUP','DATABASE','APPLICATION','DONE']

	templatedict = {
		'fields':fields,
		'data':data,
		'TODOdata':TODOdata,
		'OSdata':OSdata,
		'BACKUPdata':BACKUPdata,
		'DATABASEdata':DATABASEdata,
		'APPLICATIONdata':APPLICATIONdata,
		'DONEdata':DONEdata,
		'statusfields':statusfields
	}

	file="recovery/index.html"
	return render(request,file,templatedict)

# @csrf_exempt
# def get_server_input_form(request):
# 	name = request.POST.get('name')
# 	return HttpResponse(name)

def login(request):
	return render(request,"recovery/login.html")

def serverdetails(request):
	#server = request.POST.get('server')
	server="dlet306"
	con = sqlite3.connect('/Users/ameen/Desktop/tecathon/dbcreate.db')
	cur = con.cursor()
	cur.execute("select * from adminupload where server='"+server+"'")
	data=cur.fetchone()
	return render(request,"recovery/serverdetails.html",{'data':data})

@csrf_exempt
def afterlogin(request):
	name = request.POST.get('name')
	password = request.POST.get('pass')
	con = sqlite3.connect('/Users/ameen/Desktop/tecathon/dbcreate.db')
	cur = con.cursor()
	print("name and password",name,password)
	cur.execute("select usertype from userlogin where userid='"+name+"' and password='"+password+"'")
	data=cur.fetchone()
	print("printing data of login: ",data)
	file=""
	dictt={}
	if data[0]=="U":
		cur.execute("select server,queue from usertoqueue where userid='usr1'")
		data=cur.fetchall()
		fields=["server","queue"]
		file="recovery/usertoqueue.html"
		dictt={"data":data,"fields":fields}
	elif data[0]=="A":
		file="recovery/server_input.html"
	elif data[0]=="C":
		file="recovery/controllerPage.html"
	print("printing file name : ",file)
	return render(request,file,dictt)


def servers_upload(request):
	
	
	for i in data_list:
		cur.execute("insert into adminupload(server,description,priority,status) values('"+i[0]+"','"+i[1]+"','"+i[2]+"','"+i[3]+"')")
		status=i[3]
		status=status.split(",")[0]
		cur.execute("insert into statustrack (server,status,userid,start,end) values('"+i[0]+"','"+status+"','null','null','null')")
		con.commit()
	print("Opened database successfully");
	cur.execute("select * from adminupload")
	fields=['server_name','description','priority','status']
	data = cur.fetchall()
	return render(request,"recovery/server_info.html",{'fields':fields,'datadb':data})

def csv_upload(request):
	
	data_list = []
	
	with open("C:/Users/x0275716/Desktop/adminupload.csv") as csvfile:
		print("inside simple ........fsgfsd......")
		reader = csv.reader(csvfile,delimiter=',')
		for row in reader:
			data_list.append(row)
	data_list.pop(0)
	print (data_list)
	con = sqlite3.connect('C:/Users/x0275716/Desktop/tecathon/dbcreate.db')

	cur = con.cursor()


	if request.POST.get('name')=="users":
		for i in data_list:
			cur.execute("insert into userlogin(userid,password,usertype,queues) values('"+i[0]+"','"+i[1]+"','"+i[2]+"','"+i[3]+"')")
			con.commit()
		print("Opened database successfully");
		cur.execute("select * from adminupload")
		fields=['userid','password','usertype','queues']
		data = cur.fetchall()
		file="recovery/server_info.html"
	elif request.POST.get('name')=="servers":
		for i in data_list:
			cur.execute("insert into adminupload(server,description,priority,status) values('"+i[0]+"','"+i[1]+"','"+i[2]+"','"+i[3]+"')")
			status=i[3]
			status=status.split(",")[0]
			cur.execute("insert into statustrack (server,status,userid,start,end) values('"+i[0]+"','"+status+"','null','null','null')")
			con.commit()
		print("Opened database successfully");
		cur.execute("select * from adminupload")
		fields=['server_name','description','priority','status']
		data = cur.fetchall()
		file="recovery/server_info.html"
	return render(request,file,{'fields':fields,'datadb':data})

# def usertoqueue(request):
# 	con = sqlite3.connect('C:/Users/x0275716/Desktop/tecathon/dbcreate.db')
# 	cur = con.cursor()
# 	cur.execute("select server,queue from usertoqueue where userid='usr1'")
# 	data=cur.fetchall()
# 	fields=["server","queue"]
# 	return render(request,"recovery/usertoqueue.html",{"data":data,"fields":fields})










