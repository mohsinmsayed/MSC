import wikipedia

query = "Wikipedia"

# search method of Wikipedia
answer = wikipedia.search(query)

# getting entire information about the query
article = wikipedia.page(query)

# getting title of the page
name = article.title

# extracting url
page_url = article.url

# extracting link present in the article
links = article.links[0]
# article.links returns a list so we take only first element from the list

# changing the language of the article
wikipedia.set_lang('hi')

# read a summary of any topic in the set language
brief = wikipedia.summary(query,sentences=1)
# here sentences parameter is optional

# printing all information
print(f'Available searches are: {answer}')
print(f'Title of the page: {name}')
print(f'Page URL: {page_url}')
print(f'Available Links: {links}')
print(f'Information in different language: {brief}')