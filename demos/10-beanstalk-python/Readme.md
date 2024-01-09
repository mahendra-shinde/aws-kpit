# Python (Flask) Web application on BeanStalk

1. Create a new folder for python project

    ```cmd
    mkdir flask-app
    cd flask-app
    ```

1.  Setup VirtualEnv (Setup Environment for Application)

    ```cmd
    virtualenv virt
    pip install flask==3.0.0
    echo "flask==3.0.0" > requirments.txt
    ```

1.  Inside 'flask-app' folder create a new file `app.py`

    ```python
    from flask import Flask, render_template

    app = Flask(__name__)

    @app.route("/")
    def hello():
        return render_template('index.html')

    if __name__ == "__main__":
        app.run(host="0.0.0.0", port=5000)
    ```

1.  Create HTML Template `index.html` inside folder 'templates' 

    ```html
    <!DOCTYPE html>
    <html lang="en">
    <head>
        <meta charset="UTF-8">
        <link href="{{ url_for('static',filename='css/main.css') }}" rel="stylesheet"/>
        <title>Docker [Python] Demo </title>
    </head>
    <body>
        <div class="header">
        <h1>Hello Python World!</h1>
        </div>
        <div class="content">
        <p>Welcome to FlaskApp!</p>
        </div>
    </body>
    </html>
    ```

1.  Create the CSS file `main.css` in a another folder `static\css`

    ```css
    * {
        margin: 0px;
        padding: 0px;
    }

    .header {
        padding: 10px;
        background-color: cadetblue;
        font-family: 'Lucida Sans', 'Lucida Sans Regular', 'Lucida Grande', 'Lucida Sans Unicode', Geneva, Verdana, sans-serif;
        border-bottom: 5px solid darkkhaki;
    }

    .content {
        background-color: wheat;
        font-family: 'Segoe UI', Tahoma, Geneva, Verdana, sans-serif;
        padding: 5px;
        text-align: justify;
        height: 700px;
    }
    ```

1.  Test the application locally

    ```cmd
    c:\python312\python.exe app.py
    CTRL+C
    ```

1.  Convert entire folder `flask-app` to a ZIP file

1.  Create a new BeanStalk with Python 3.11 environment, and upload flask-app.zip