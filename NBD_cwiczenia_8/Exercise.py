import riak


def read_from_db(key, bucket):
    fetched = bucket.get(key)
    if fetched.data:
        print(fetched.data)
    else:
        print("Record not found")


def save_to_db(input_data, key, bucket):
    new_product = bucket.new(key, data=input_data)
    new_product.store()


def delete_from_db(key, bucket):
    fetched = bucket.get(key)
    fetched.delete()


def main():
    # setting up a client
    my_client = riak.RiakClient(pb_port=8087)
    db_input = {
        "name": "Cookie",
        "weight": 80,
        "price": 4.99,
        "isSweet": True
    }
    my_key = 'cookie'
    my_bucket = my_client.bucket('s23424')

    # adding record to database and reading it
    save_to_db(db_input, my_key, my_bucket)
    read_from_db(my_key, my_bucket)

    new_input = {
        "name": "Cookie",
        "weight": 70,
        "price": 5.99,
        "isSweet": True
    }
    # updating record and reading it
    save_to_db(new_input, my_key, my_bucket)
    read_from_db(my_key, my_bucket)

    # deleting record and trying to read it
    delete_from_db(my_key, my_bucket)
    read_from_db(my_key, my_bucket)


if __name__ == '__main__':
    main()

