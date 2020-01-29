url = data['repos_url']
page_no = 1
repos_data = []
while (True):
    response = requests.get(url, auth = authentication)
    response = datacollector.json()
    repos_data = repos_data + response
    repos_fetched = len(response)
    print("Total repositories fetched: {}".format(repos_fetched))
    if (repos_fetched == 30):
        page_no = page_no + 1
        url = data['repos_url'].encode("UTF-8") + '?page=' + str(page_no)
    else:
        break
